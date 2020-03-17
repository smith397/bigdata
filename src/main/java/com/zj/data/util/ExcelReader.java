package com.zj.data.util;

import com.zj.data.domin.FuntureData;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelReader {

//    public static Map<>

//    private static Logger logger = Logger.getLogger(ExcelReader.class.getName()); // 日志打印类

    private static final String XLS = "xls";
    private static final String XLSX = "xlsx";

    /**
     * 根据文件后缀名类型获取对应的工作簿对象
     * @param inputStream 读取文件的输入流
     * @param fileType 文件后缀名类型（xls或xlsx）
     * @return 包含文件数据的工作簿对象
     * @throws IOException
     */
    public static Workbook getWorkbook(InputStream inputStream, String fileType) throws IOException {
        Workbook workbook = null;
        if (fileType.equalsIgnoreCase(XLS)) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (fileType.equalsIgnoreCase(XLSX)) {
            workbook = new XSSFWorkbook(inputStream);
        }
        return workbook;
    }

    /**
     * 读取Excel文件内容
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<FuntureData> readExcel(String fileName) {

        Workbook workbook = null;
        FileInputStream inputStream = null;
        List<FuntureData> funtureDataList =null;
        try {
            // 获取Excel后缀名
            String fileType = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                log.warn("指定的Excel文件不存在！");
                return null;
            }
            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = getWorkbook(inputStream, fileType);
            funtureDataList = parseExcel(workbook);
        } catch (Exception e) {
            log.warn("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                log.warn("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
        return funtureDataList;
    }

    /**
     * 解析Excel数据
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<FuntureData> parseExcel(Workbook workbook) {
//        List<ExcelDataVO> resultDataList = new ArrayList<>();
        // 解析sheet
        List<FuntureData> funtureDataList = null;
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);
            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }
            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            int cellNum=1;
            List<String> time =new ArrayList<>();
            while (true) {
                Cell cell = firstRow.getCell(cellNum++);
                String s = convertCellValueToString(cell);
                if (s==null) break;
                time.add(s);
            }
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            int cellNum1 = 1;
            funtureDataList = new ArrayList<>();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);
                while (true) {
//                    System.out.println(rowNum);
                    if (cellNum1>24)
                    {
                        cellNum1=1;
                        break;
                    }
                    Cell cell = row.getCell(cellNum1);
                    String s = convertCellValueToString(cell);
                    FuntureData funtureData = new FuntureData();
                    funtureData.setStatus(s);
                    funtureData.setWeek(convertCellValueToString(row.getCell(0)));
                    funtureData.setDate(time.get(cellNum1-1));
                    cellNum1++;
                    funtureDataList.add(funtureData);
                }
                if (null == row) {
                    continue;
                }
            }
        }
        return funtureDataList;
    }

//        return resultDataList;


//    /**
//     * 将单元格内容转换为字符串
//     * @param cell
//     * @return
//     */
    private static String convertCellValueToString(Cell cell) {
        if(cell==null){
            return null;
        }
        String returnValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:   //数字
                Double doubleValue = cell.getNumericCellValue();
                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }
}