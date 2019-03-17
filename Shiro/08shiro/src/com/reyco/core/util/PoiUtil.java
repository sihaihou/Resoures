package com.reyco.core.util;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class PoiUtil {
	
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
	 * 根据模板
	 * @param students
	 * @param keys
	 * @param fileName
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
		if(null == cell) {
			return "";
		}else{
			if(cell .getCellType() ==HSSFCell.CELL_TYPE_BOOLEAN) {
				return String.valueOf(cell.getBooleanCellValue());
			}else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			}else {
				return String.valueOf(cell.getStringCellValue());
			}
		}
	}
	
	
}
