package com.maowei.learning.orm;

import com.maowei.learning.orm.dao.FundInfoDao;
import com.maowei.learning.orm.impl.FixAmountAIP;
import com.maowei.learning.orm.impl.LimitedValueAverageAIP;
import com.maowei.learning.orm.impl.ValueAverageAIP;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FundAIPTest {
    public static void main(String[] args) throws IOException{
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("spring/SqlMapConfig.xml"));

        SqlSession session1 = sqlSessionFactory.openSession(true);

        FundInfoDao dao = session1.getMapper(FundInfoDao.class);

        List<FundInfo> list = dao.getFundInfoByFundCode(Config.FUND_CODE);

        List<FundAIPResult> aIPList = new ArrayList<FundAIPResult>();

        int i = 0;

        String fundName = list.get(0).getFundName();

        FundAIPResult pre = new FundAIPResult();

        //FundAIPCalculateInf inf = new ValueAverageAIP();
        //FundAIPCalculateInf inf = new FixAmountAIP();
        FundAIPCalculateInf inf = new LimitedValueAverageAIP();


        for(FundInfo f : list){
            if(null != f.getBouns()){
                pre.refresh(f);
            }
            if(i%Config.PERIOD_DAYS == 0){
                FundAIPResult newAIP = inf.doCalculate(pre, f);
                aIPList.add(newAIP);
                pre = newAIP;

//                if(pre.getBenefitRate() > 0.8){
//                    pre = new FundAIPResult();
//                }
            }
            i++;
        }

        File file = new File(Config.FILE_PATH+Config.FUND_CODE+"_"+ fundName +".xls");
        if (!file.exists()) {
            file.createNewFile();
        }


        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet =wb.createSheet("基金定投计划");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("日期");
        row.createCell(1).setCellValue("当前净值");
        row.createCell(2).setCellValue("目标市值");
        row.createCell(3).setCellValue("当期赎回");
        row.createCell(4).setCellValue("当期投入");
        row.createCell(5).setCellValue("累计赎回");
        row.createCell(6).setCellValue("当期份额");
        row.createCell(7).setCellValue("总投入");
        row.createCell(8).setCellValue("总份额");
        row.createCell(9).setCellValue("总市值");
        row.createCell(10).setCellValue("收益率");

        for(i=0;i<11;i++){
            sheet.autoSizeColumn(i);
        }

        i=1;

        DecimalFormat df1 = new DecimalFormat("#,##0.000#");
        DecimalFormat df2 = new DecimalFormat("#,##0.0#");
        DecimalFormat df3 = new DecimalFormat("0.0#%");

        for(FundAIPResult f : aIPList){
            row = sheet.createRow(i++);
            row.createCell(0).setCellValue(f.getDate());
            row.createCell(1).setCellValue(df1.format(f.getCurrNetValue()));
            row.createCell(2).setCellValue(df2.format(f.getTargetValue()));
            row.createCell(3).setCellValue(df2.format(f.getCurrSold()));
            row.createCell(4).setCellValue(df2.format(f.getCurrInput()));
            row.createCell(5).setCellValue(df2.format(f.getTotalSold()));
            row.createCell(6).setCellValue(df1.format(f.getCurrShare()));
            row.createCell(7).setCellValue(df2.format(f.getTotalInput()));
            row.createCell(8).setCellValue(df1.format(f.getTotalShare()));
            row.createCell(9).setCellValue(df2.format(f.getTotalValue()));
            row.createCell(10).setCellValue(df3.format(f.getBenefitRate()));
        }

        OutputStream os = new FileOutputStream(file);
        wb.write(os);
        os.flush();
        os.close();

    }
}
