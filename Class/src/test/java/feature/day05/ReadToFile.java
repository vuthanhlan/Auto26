package feature.day05;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadToFile {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileInputStream file = new FileInputStream("dataLogin.xlsx");
             //khoi tao workbook
             Workbook workbook = new XSSFWorkbook(file)) {


            Sheet sheetDataLogin = workbook.getSheetAt(0);
            DataFormatter dataFormatter = new DataFormatter();

            //Đọc dữ liệu từ file
            for (Row row : sheetDataLogin) {
                if (row.getRowNum() == 0) continue;

                String user = dataFormatter.formatCellValue(row.getCell(0)).trim();
                String pass= dataFormatter.formatCellValue(row.getCell(1)).trim();

                if(!user.isEmpty() || !pass.isEmpty()){
                    System.out.println("user: "+user);
                    System.out.println("pass: "+pass);
                }
            }
        } catch (Exception e) {
            System.err.println("Đã xảy ra lỗi khi đọc file Excel:" + e.getMessage());
        }

    }
}
