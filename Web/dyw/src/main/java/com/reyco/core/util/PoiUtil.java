package com.reyco.core.util;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

@SuppressWarnings("all")
public class PoiUtil {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	/*
	 * getLastRowNum:  
     * 		如果sheet中一行数据都没有则返回-1，只有第一行有数据则返回0，最后有数据的行是第n行则返回 n-1；
	 * getLastCellNum   
     *		如果row中一列数据都没有则返回-1，只有第一列有数据则返回1，最后有数据的列是第n列则返回 n；
	 * getPhysicalNumberOfRows  
     *      获取有记录的行数，即：最后有数据的行是第n行，前面有m行是空行没数据，则返回n-m；
	 * getPhysicalNumberOfCells   
     *		获取有记录的列数，即：最后有数据的列是第n列，前面有m列是空列没数据，则返回n-m；
	 */
	
	/**
	 *  将数据写入到表格文件
	 * @param entitys         select的数据
	 * @param wb              表格
	 * @param keys           
	 * @param columnNames     列名
	 */
	public static void excelData(List<Map<String,Object>> entitys, Workbook wb,String[] keys,String[] columnNames) {
		int rowIndex =0;
		Sheet sheet = wb.createSheet();
		Row row = sheet.createRow(rowIndex++);
		for(int i=0;i<columnNames.length;i++) {
			row.createCell(i).setCellValue(columnNames[i]);
		}
		for(int i=0;i<entitys.size();i++) {
			row=sheet.createRow(i+1);
			for(int j=0;j<keys.length;j++) {
				row.createCell(j).setCellValue(entitys.get(i).get(keys[j]).toString());
			}
		}
	}
	/**
	 * 读取模板文件   将数据写入到模板文件
	 * @param list       select的数据
	 * @param keys       列名
	 * @param fileName   模板文件名
	 * @return
	 * @throws Exception
	 */
	public static Workbook excelTemplate(List<Map<String,Object>> list,String[] keys,String fileName) throws Exception {
		InputStream is = PoiUtil.class.getResourceAsStream(fileName);
		POIFSFileSystem poi = new POIFSFileSystem(is);
		Workbook wb = new HSSFWorkbook(poi);
		Sheet sheet = wb.getSheetAt(0);
		int cellNums = sheet.getRow(0).getLastCellNum();
		for(int i=1;i<list.size();i++) {
			Row row = sheet.createRow(i);
			for(int j=0;j<cellNums;j++) {
				row.createCell(j).setCellValue(list.get(i).get(keys[j]).toString());
			}
		}
		return wb;
	}
	/**
	 * 获取HSSFCell类型
	 * @param cell
	 * @return
	 */
	public static String formatCell(HSSFCell cell) {
		//如果cell为null直接return
		if(null == cell) {
			return "";
		}else{
			//设置所有单元格为String类型
			cell.setCellType(cell.CELL_TYPE_STRING);
			// 获取String类型单元格内容
			return String.valueOf(cell.getStringCellValue());
		}
	}
	/**
	 *      获取hssfcell单元格格式内容
	 * 
	 * @param hssfCell
	 * @return
	 */
	public static String getHSSFCellValue(HSSFCell hssfcell) {
		if (hssfcell.getCellType() == hssfcell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfcell.getBooleanCellValue());
		} else if (hssfcell.getCellType() == hssfcell.CELL_TYPE_NUMERIC) {
			String cellValue = "";
			if (HSSFDateUtil.isCellDateFormatted(hssfcell)) {
				Date date = HSSFDateUtil.getJavaDate(hssfcell.getNumericCellValue());
				cellValue = sdf.format(date);
			} else {
				DecimalFormat df = new DecimalFormat("#.##");
				cellValue = df.format(hssfcell.getNumericCellValue());
				String strArr = cellValue.substring(cellValue.lastIndexOf("") + 1, cellValue.length());
				if (strArr.equals("00")) {
					cellValue = cellValue.substring(0, cellValue.lastIndexOf("."));
				}
			}
			return cellValue;
		}else if(hssfcell.getCellType() ==HSSFCell.CELL_TYPE_ERROR) {
			return "";
		}else {
			return String.valueOf(hssfcell.getStringCellValue());
		}
	}
	/** 
     *      获取XSSFCell单元格格式的内容
     * @param xssfCell 
     * @return 
     */  
    public static String getXSSFCellValue(XSSFCell xssfCell){  
         if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {  
             return String.valueOf(xssfCell.getBooleanCellValue());  
         } else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {  
             String cellValue = "";  
             DecimalFormat df = new DecimalFormat("#.##");  
             cellValue = df.format(xssfCell.getNumericCellValue());  
             String strArr = cellValue.substring(cellValue.lastIndexOf(".")+1,cellValue.length());  
             if(strArr.equals("00")){  
                 cellValue = cellValue.substring(0, cellValue.lastIndexOf("."));  
             }    
             return cellValue;  
         }else if(xssfCell.getCellType()==HSSFCell.CELL_TYPE_ERROR) {
				return "";
		 } else {  
        	 return String.valueOf(xssfCell.getStringCellValue());  
         }  
    }
	
	
}
