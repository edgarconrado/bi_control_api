package com.belz.bicontrolapi.service;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belz.bicontrolapi.viewModel.ExcellModel;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FontUnderline;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import lombok.Getter;

@Getter
public class ExcellCreator {

    private static final Logger logger = Logger.getLogger(String.valueOf(ExcellCreator.class));

    /**
     * These fields are exposed as getters in case specific sytles needs to be applied
     * when generating the table
     */
    private XSSFCellStyle columnHeaderCellStyle;
    private CellStyle labelCenterCellStyle;
    private CellStyle mainTitleCellStyle;
    private CellStyle moneyStyle;
    private CellStyle dataStyle;
    private CellStyle dateStyle;
    private CellStyle decimalStyle;

    public Workbook build(String reportTitle, String sheetTitle, ExcellModel model) {

        Workbook workbook = new XSSFWorkbook();
        setupStyles(workbook);

        Sheet sheet = workbook.createSheet(sheetTitle);

        int rowOffset = createHeader(sheet, workbook, reportTitle, model.getColumnTitles());
        rowOffset = fillReport(sheet, model.getData(), rowOffset, model.getModelFieldNames());
        return workbook;
    }

    protected int createHeader(Sheet sheet, Workbook workbook, String reportTitle, List<String> columnTitles) {
        int rowOffset = 0;
        Row headerRow = sheet.createRow(rowOffset);
        headerRow.setHeightInPoints((2 * sheet.getDefaultRowHeightInPoints()));
        Cell cell = headerRow.createCell(2);
        cell.setCellValue(reportTitle);
        cell.setCellStyle(mainTitleCellStyle);
        cell.getCellStyle().setIndention((short) 1);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
        if (columnTitles.size()>3) {
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, columnTitles.size()-1));
        }

        InputStream inputStream1 = ExcellCreator.class.getClassLoader().getResourceAsStream("oreilly_logo.png");
        try {
            byte[] inputImageBytes1 = IOUtils.toByteArray(inputStream1);
            int inputImagePictureID1 = workbook.addPicture(inputImageBytes1, Workbook.PICTURE_TYPE_PNG);
            XSSFDrawing drawing = (XSSFDrawing) sheet.createDrawingPatriarch();
            XSSFClientAnchor imageAnchor = new XSSFClientAnchor();
            imageAnchor.setCol1(0);
            imageAnchor.setCol2(2);
            imageAnchor.setRow1(0);
            imageAnchor.setRow2(1);
            drawing.createPicture(imageAnchor, inputImagePictureID1);
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        short columnWidth = (short) sheet.getColumnWidth(0);
        for (int i = 0; i < columnTitles.size(); i++) {
            /**
             * Using the Calibri font as an example, the maximum digit width of 11 point font size (pfs) is 7 pixels (at 96 dpi).
             * If you set a column width to be eight characters wide, e.g. <code>setColumnWidth(columnIndex, 8*256)</code>,
             *
             * Excel uses the following formula (Section 3.3.1.12 of the OOXML spec) to compute actual value of visible characters
             * pfs = Truncate([{Number of Visible Characters} * {Maximum Digit Width} + {25 pixel padding}]/{Maximum Digit Width}*256)/256
             *
             * then coloumn width is:
             * setColumnWidth(columnIndex, pfs*256)
             */
            columnWidth = (short) (((columnTitles.get(i).length() * 8.0 +25)/8.0*256.0));
            sheet.setColumnWidth(i, columnWidth);
        }

        Row row = sheet.createRow(++rowOffset);
        row.setHeight((short) (row.getHeight() * 3.5));
        // Table 1 [Linea ...]
        for (int col = 0; col < columnTitles.size(); col++) {
            cell = row.createCell(col);
            cell.setCellValue(columnTitles.get(col));
            cell.setCellStyle(columnHeaderCellStyle);
        }
        row = sheet.createRow(++rowOffset);
        row.setHeight((short) (row.getHeight() * .5));

        return rowOffset;
    }

    private int fillReport(Sheet sheet, List<? extends Object> dataList, int rowOffset, List<String> fieldNames) {
        Row row;
        Cell cell;

        // Fill Table 1
        for (Object data : dataList) {
            row = sheet.createRow(rowOffset);
            int cellIndex = -1;
            for (int i = 0; i < fieldNames.size(); i++) {
                try {
                    Field field = data.getClass().getDeclaredField(fieldNames.get(i));
                    field.setAccessible(true);
                    cell = row.createCell(++cellIndex);
                    Object value = field.get(data);
                    if (value != null) {
                        cell.setCellValue(value.toString());

                        if (value instanceof Date) {
                            cell.setCellStyle(dateStyle);
                            cell.setCellValue((Date) value);
                        } else if (value instanceof Double) {
                            cell.setCellStyle(decimalStyle);
                            cell.setCellValue((Double) value);
                        } else if (value instanceof Float) {
                            cell.setCellStyle(decimalStyle);
                            cell.setCellValue((Float) value);
                        } else {
                            cell.setCellStyle(dataStyle);
                            cell.setCellValue(value.toString());
                        }

                    }
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    logger.log(Level.SEVERE, e.getMessage(), e);
                }

            }
            rowOffset++;
        }
        return rowOffset;
    }

    protected void setupStyles(Workbook workbook) {
        Font font = workbook.createFont();
        font.setBold(true);

        mainTitleCellStyle = workbook.createCellStyle();
        mainTitleCellStyle.setAlignment(HorizontalAlignment.LEFT);
        mainTitleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font fontTitle = workbook.createFont();
        fontTitle.setBold(true);
        fontTitle.setFontHeightInPoints((short) 12);
        mainTitleCellStyle.setFont(fontTitle);

        font = workbook.createFont();
        if (font instanceof XSSFFont) {
            XSSFFont xssfFont = (XSSFFont) font;
            xssfFont.setFontHeight(10);
        } else {
            font.setFontHeight((short) 1);
        }

        font = workbook.createFont();
        font.setBold(true);
        font.setUnderline(FontUnderline.SINGLE.getByteValue());
        if (font instanceof XSSFFont) {
            byte[] rgb = new byte[] { (byte) 0, (byte) 112, (byte) 202 };
            XSSFFont xssfFont = (XSSFFont) font;
            xssfFont.setColor(new XSSFColor(rgb));
            xssfFont.setUnderline(FontUnderline.SINGLE);
        } else if (font instanceof HSSFFont) {
            font.setColor(IndexedColors.BLUE.getIndex());
        }

        labelCenterCellStyle = workbook.createCellStyle();
        labelCenterCellStyle.setFont(font);
        labelCenterCellStyle.setWrapText(true);
        labelCenterCellStyle.setWrapText(true);
        labelCenterCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        labelCenterCellStyle.setAlignment(HorizontalAlignment.CENTER);

        Font fontHeader = workbook.createFont();
        fontHeader.setColor(IndexedColors.WHITE.index);
        fontHeader.setBold(true);
        fontHeader.setFontHeightInPoints((short) 12);
        columnHeaderCellStyle = (XSSFCellStyle) workbook.createCellStyle();
        columnHeaderCellStyle.cloneStyleFrom(labelCenterCellStyle);
        columnHeaderCellStyle.setBorderBottom(BorderStyle.THIN);
        columnHeaderCellStyle.setBorderTop(BorderStyle.THIN);
        columnHeaderCellStyle.setBorderRight(BorderStyle.THIN);
        columnHeaderCellStyle.setBorderLeft(BorderStyle.THIN);
        columnHeaderCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFColor myColor = new XSSFColor(new java.awt.Color(9, 143, 62));
        columnHeaderCellStyle.setFillForegroundColor(myColor);
        columnHeaderCellStyle.setFont(fontHeader);

        dataStyle = workbook.createCellStyle();
        dataStyle.cloneStyleFrom(labelCenterCellStyle);
        dataStyle.setFont(workbook.createFont());
        dataStyle.setWrapText(false);

        moneyStyle = workbook.createCellStyle();
        moneyStyle.cloneStyleFrom(dataStyle);
        moneyStyle.setAlignment(HorizontalAlignment.GENERAL);
        moneyStyle.setDataFormat(workbook.createDataFormat()
                .getFormat("_([$$-en-US]* #,##0.00_);_([$$-en-US]* (#,##0.00);_([$$-en-US]* \"-\"??_);_(@_)"));

        dateStyle = workbook.createCellStyle();
        dateStyle.cloneStyleFrom(dataStyle);
        dateStyle.setDataFormat(workbook.createDataFormat().getFormat("yyyy-mm-d"));

        decimalStyle = workbook.createCellStyle();
        decimalStyle.cloneStyleFrom(dataStyle);
        decimalStyle.setDataFormat(workbook.createDataFormat().getFormat("0.0000"));
    }
}