package com.onuz.stock;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "author", catalog = "library", uniqueConstraints = {
		@UniqueConstraint(columnNames = "AUTHOR_NAME"),
		@UniqueConstraint(columnNames = "AUTHOR_SURNAME") })
public class Author implements java.io.Serializable {

	private Integer authorId;
	private String authorSurname;
	private String authorName;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(
			0);

	public Author() {
	}

	public Author(String authorSurname, String authorName) {
		this.authorSurname = authorSurname;
		this.authorName = authorName;
	}

	public Author(String authorSurname, String authorName,
			Set<Book> stockDailyRecords) {
		this.authorSurname = authorSurname;
		this.authorName = authorName;
		this.stockDailyRecords = stockDailyRecords;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Column(name = "AUTHOR_SURNAME", unique = true, nullable = false, length = 10)
	public String getAuthorSurname() {
		return this.authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	@Column(name = "AUTHOR_NAME", unique = true, nullable = false, length = 20)
	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
	public Set<StockDailyRecord> getStockDailyRecords() {
		return this.stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

}
