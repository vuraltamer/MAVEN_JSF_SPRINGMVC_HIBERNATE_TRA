package com.onuz;

import java.util.Date;

import org.hibernate.Session;

import com.onuz.stock.Stock;
import com.onuz.stock.StockDailyRecord;
import com.onuz.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        session.save(stock);
        
        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        
        stockDailyRecords.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecords);

        session.save(stockDailyRecords);
        
        StockDailyRecord nsd = new StockDailyRecord();
        nsd.setPriceOpen(new Float("2"));
        nsd.setPriceClose(new Float("3"));
        nsd.setPriceChange(new Float("12.0"));
        nsd.setVolume(3000000L);
        nsd.setDate(new Date());
        
        nsd.setStock(stock);        
        stock.getStockDailyRecords().add(nsd);

        session.save(nsd);
        
        

		session.getTransaction().commit();
		System.out.println("Done");
	}
}
