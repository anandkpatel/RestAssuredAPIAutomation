package com.sample.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class XlUtils {


    private static FileInputStream fis;
    private static FileOutputStream fo;
    private static XSSFWorkbook wb;
    private static XSSFSheet ws;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static int rowcount;
    private static int colcount;

    public XlUtils(String path, String SheetName) throws Exception {
        fis = new FileInputStream(path);
        wb = new XSSFWorkbook(fis);
        ws = wb.getSheet(SheetName);


    }

    public static Object[][] getData(String path, String SheetName) throws Exception {

        XlUtils excel = new XlUtils(path, SheetName);
        Object[][] data;
        int rownum = excel.getRowCount();
        int colnum = excel.getColumnCount();



        data = new Object[rownum][colnum];

        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colnum; j++) {

                data[i - 1][j] = excel.getCellData(path, SheetName, i, j);
                System.out.println("data ==> " +data[i - 1][j]);

            }
        }
        return data;

    }

    public int getRowCount() {

        rowcount = ws.getLastRowNum();
        return rowcount;
    }

    public int getColumnCount() {

        colcount = ws.getRow(0).getLastCellNum();
        return colcount;

    }

    public String getCellData(String path, String SheetName, int rownum, int colnum) {
        //XlUtils excel = new XlUtils(path, SheetName);
        row = ws.getRow(rownum);
        cell = row.getCell(colnum);
        String data;
        try {
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);

        } catch (Exception e) {
            data = "";
        }
        System.out.println(data);
        return data;
    }


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*static FileInputStream fis;
	static Workbook wb;
	static Sheet sheet;
	public static int getRowCount(String path, String sheetname) throws Exception
	{
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sheet =  wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();	
		wb.close();
		fis.close();
		return rowcount;
		
		
	}
	
	public static int getColumnCount(String path, String sheetname) throws Exception
	{
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet =  wb.getSheet(sheetname);	
		wb.close();
		fis.close();
		int colcount = sheet.getRow(0).getLastCellNum();
		return colcount;
		
		
	}
	public static void main(String[] args) throws Exception
	{
		
		String path = "C:\\Users\\Anand\\Desktop\\create_user.xlsx";
		//String path= "C:\\Users\\Anand\\eclipse\\java_code"+ "\\SeleniumCodingAssignment_26th_may\\src\\main\\java\\com\\ca\\testdata\\create_user.xlsx";
		System.out.println(System.getProperty("user.dir") + "\\src\\main\\java\\com\\ca\\testdata\\create_user.xlsx");
		System.out.println(getRowCount(path, "data1"));
		System.out.println(getColumnCount(path, "data1"));
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
		/*public static int getRowCount(String xlfile) throws IOException 
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheetAt(0);
		int rowcount=ws.getPhysicalNumberOfRows();
		//wb.close();
		fi.close();
		return rowcount;		
	}
	
	
	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		//wb.close();
		fi.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}*/
	
	
	

	

	
	

