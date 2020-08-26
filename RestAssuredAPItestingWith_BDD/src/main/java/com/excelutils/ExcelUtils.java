package com.excelutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtils{

	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  Workbook wb;
	public  Sheet ws;
	public  Row row;
	public Row excelRow;
	public  Cell cell;
	public  Cell excelCell;
	public  CellStyle style;
	public  int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	public  int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public  String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			data = cell.getStringCellValue();
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	
    public  Integer getCellNumericData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {

    	
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		Integer data = null;
		try {
			
			data = Integer.valueOf((int) cell.getNumericCellValue());
		} catch (Exception e) {
			// data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public  void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data)
			throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		
		row = ws.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);//1234
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	
	public  void setCellDataforMultiple(String xlfile, String xlsheet, int rownum,int colnum,String requestId)
	throws IOException, InterruptedException {
		//logger.info("inside setCellDatas");
		
		String idvalue = null;
		//logger.info("data insert in excel :" + requestId);//18937
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
	
		
			
		if (excelCell == null) {
			row = ws.getRow(rownum);//1
			System.out.println("row count  : " + rownum);
			System.out.println("1st itteration crusor will go to if and set data");
			excelCell=row.createCell(colnum);
		//	logger.info("inside if");
			 
			Thread.sleep(6000);
			excelCell.setCellValue(requestId);//1
			idvalue  =excelCell.getStringCellValue();
			System.out.println("idvalue : " + idvalue);//123
			 //logger.info("data :" + idvalue);
			 FileOutputStream fo1 = new FileOutputStream(xlfile);
			wb.write(fo1);
	
			//logger.info("print cell value :"+ excelCell.getStringCellValue());//18936
			// idvalue=cell.getStringCellValue();

	
			
		}
		
		
		else if (excelCell != null) {
			System.out.println("after 1st itteration crusor will go to always else if ");
			
			rownum++;
			row = ws.getRow(rownum);//1
			System.out.println("row count : " + rownum);
			Cell excelCell1=row.createCell(colnum);
			//logger.info("inside else print cell value :"+ excelCell.getStringCellValue());
			//excelCell1.setCellValue(excelCell.getStringCellValue()+"/"+requestId);
			//logger.info("print cell value :"+ excelCell1.getStringCellValue());
			FileOutputStream fo2 = new FileOutputStream(xlfile);
			wb.write(fo2);
			excelCell = excelCell1;
			//logger.info("print cell value :"+ excelCell.getStringCellValue());
		
		}
		
		
		/*		else  {
					System.out.println("after 1st itteration crusor will go to always else");
					rownum++;
					System.out.println("row count : " + rownum);
					Cell excelCell1=row.createCell(colnum);
					//logger.info("inside else print cell value :"+ excelCell.getStringCellValue());
					//excelCell1.setCellValue(excelCell.getStringCellValue()+"/"+requestId);
					//logger.info("print cell value :"+ excelCell1.getStringCellValue());
					FileOutputStream fo2 = new FileOutputStream(xlfile);
					wb.write(fo2);
					excelCell = excelCell1;
					//logger.info("print cell value :"+ excelCell.getStringCellValue());
				}*/
			 
		idvalue=excelCell.getStringCellValue();
      		//logger.info("print cell value end :"+ excelCell.getStringCellValue());
		//rowcount ++;
		}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public  void setCellDatas(String xlfile, String xlsheet, int rownum,int colnum,String requestId)
	throws IOException, InterruptedException {
		//logger.info("inside setCellDatas");
		String idvalue = null;
		//logger.info("data insert in excel :" + requestId);//18937
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		if (excelCell == null) {
			excelCell=row.createCell(colnum);
		//	logger.info("inside if");
			 
			Thread.sleep(6000);
			excelCell.setCellValue(requestId);
			idvalue  =excelCell.getStringCellValue();
			Thread.sleep(4000);
			 //logger.info("data :" + idvalue);
			 FileOutputStream fo1 = new FileOutputStream(xlfile);
			wb.write(fo1);
	
			//logger.info("print cell value :"+ excelCell.getStringCellValue());//18936
			// idvalue=cell.getStringCellValue();

	
			Thread.sleep(2000);
		}
		
				else  {
					Cell excelCell1=row.createCell(colnum);
					//logger.info("inside else");
					//logger.info("inside else print cell value :"+ excelCell.getStringCellValue());
					excelCell1.setCellValue(excelCell.getStringCellValue()+"/"+requestId);
					//logger.info("print cell value :"+ excelCell1.getStringCellValue());
					FileOutputStream fo2 = new FileOutputStream(xlfile);
					wb.write(fo2);
					excelCell = excelCell1;
					//logger.info("print cell value :"+ excelCell.getStringCellValue());
				}
			 
		idvalue=excelCell.getStringCellValue();
      		//logger.info("print cell value end :"+ excelCell.getStringCellValue());
	

	}

	
	public  void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public  void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public  String[][] excelData(String excelPath, String sheetName, int rownum) throws IOException {

		String[][] data = null;
		File src = new File(excelPath);
		fi = new FileInputStream(src);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		int row = ws.getLastRowNum();
		//logger.info(row);
		int cols = ws.getRow(rownum).getLastCellNum();
	//	logger.info(cols);
		data = new String[row][cols];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j <= cols - 1; j++) {
				DataFormatter format = new DataFormatter();
				Cell cell = ws.getRow(j).getCell(j);
				data[i - 1][j] = format.formatCellValue(cell);
			}
		}
		return data;
	}



	
	/*public static void setCellDataWithMultipleValue(String xlfile, String xlsheet, int rownum, int colnum,String data) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);


		List<Class> list = new ArrayList<Class>();

        Iterator<Row> itr = ws.iterator();
        String newName = null; 
        String oldName = null;

        while(itr.hasNext()){
            Row nextRow = itr.next();
            // For each row, iterate through all the columns
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) 
            {
               Cell cell = cellIterator.next();

                newName =  nextRow.getCell(0).toString();

                if(nextRow.getCell(1).toString().contains(",")){
                    StringTokenizer st = new StringTokenizer(nextRow.getCell(1).toString(),",");
                    while(st.hasMoreTokens()){
                        oldName = st.nextToken();
                    }
               }
                else{
                     oldName = nextRow.getCell(1).toString();
                    }
            }
            logger.info();
        }  
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
        
        
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	

}
