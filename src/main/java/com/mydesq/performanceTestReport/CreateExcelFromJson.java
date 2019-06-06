package com.mydesq.performanceTestReport;

import com.mydesq.automation.framework.utils.ExcelCellStyles;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class CreateExcelFromJson {

    public static void main(String[] a) throws IOException {

        ReadJson readJson = new ReadJson();
        HashMap<String, ResultObjects> resultObjects = readJson.getResultObjects();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Result");
        ExcelCellStyles styles = new ExcelCellStyles(workbook);

        int rownum = 0;
        int cellnum = 0;

        Row row = sheet.createRow(rownum++);

        Cell cell = row.createCell(cellnum++);
        cell.setCellValue("Api Endpoint");
        cell.setCellStyle(styles.getStyle(
                ExcelCellStyles.ColorStyle.CORNFLOWER_BLUE,
                null, ExcelCellStyles.ColorStyle.Black,
                null,
                ExcelCellStyles.TextAlignment.Centre,
                ExcelCellStyles.TextUnderline.None,
                true));

        cell = row.createCell(cellnum++);
        cell.setCellValue("Status Code");
        cell.setCellStyle(styles.getStyle(
                ExcelCellStyles.ColorStyle.CORNFLOWER_BLUE,
                null, ExcelCellStyles.ColorStyle.Black,
                null,
                ExcelCellStyles.TextAlignment.Centre,
                ExcelCellStyles.TextUnderline.None,
                true));

        cell = row.createCell(cellnum++);
        cell.setCellValue("Total Request Time");
        cell.setCellStyle(styles.getStyle(
                ExcelCellStyles.ColorStyle.CORNFLOWER_BLUE,
                null, ExcelCellStyles.ColorStyle.Black,
                null,
                ExcelCellStyles.TextAlignment.Centre,
                ExcelCellStyles.TextUnderline.None,
                true));

        cell = row.createCell(cellnum++);
        cell.setCellValue("Server Execution Time");
        cell.setCellStyle(styles.getStyle(
                ExcelCellStyles.ColorStyle.CORNFLOWER_BLUE,
                null, ExcelCellStyles.ColorStyle.Black,
                null,
                ExcelCellStyles.TextAlignment.Centre,
                ExcelCellStyles.TextUnderline.None,
                true));

        cell = row.createCell(cellnum++);
        cell.setCellValue("Time Taken on Machine");
        cell.setCellStyle(styles.getStyle(
                ExcelCellStyles.ColorStyle.CORNFLOWER_BLUE,
                null, ExcelCellStyles.ColorStyle.Black,
                null,
                ExcelCellStyles.TextAlignment.Centre,
                ExcelCellStyles.TextUnderline.None,
                true));

        for (String endpoint : resultObjects.keySet()) {
            cellnum = 0;
            row = sheet.createRow(rownum++);

            cell = row.createCell(cellnum++);
            cell.setCellValue(endpoint);

            cell = row.createCell(cellnum++);
            cell.setCellValue(resultObjects.get(endpoint).getStatusCode());

            cell = row.createCell(cellnum++);
            cell.setCellValue(resultObjects.get(endpoint).getTotalRequestTime());

            cell = row.createCell(cellnum++);
            cell.setCellValue(resultObjects.get(endpoint).getServerExecutionTime());

            cell = row.createCell(cellnum++);
            cell.setCellValue(resultObjects.get(endpoint).getTimeTakenOnMachine());
        }

        for (int i = 0; i < 8; i++)
            sheet.autoSizeColumn(i);

        FileOutputStream out = new FileOutputStream(new File("result.xlsx"));
        workbook.write(out);
        out.close();
    }
}
