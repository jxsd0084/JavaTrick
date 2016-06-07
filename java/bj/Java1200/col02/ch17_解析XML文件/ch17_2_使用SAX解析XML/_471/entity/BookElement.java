/**
 * @jdk版本:1.6
 * @编码时间:2010-3-20
 */
package bj.Java1200.col02.ch17_解析XML文件.ch17_2_使用SAX解析XML._471.entity;

import java.io.Serializable;
import java.net.URL;

/**
 *
 */
public class BookElement implements Serializable {

	private String name;
	private String publisher;
	private String company;
	private String author;
	private String isbn;
	private Double price;
	private URL url;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public URL getUrl() {
		return this.url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append("name=" + this.name + "\n");
		buffer.append("publisher=" + this.publisher + "\n");
		buffer.append("company=" + this.company + "\n");
		buffer.append("author=" + this.author + "\n");
		buffer.append("isbn=" + this.isbn + "\n");
		buffer.append("price=" + this.price + "\n");
		buffer.append("url=" + this.url + "\n");

		return buffer.toString();
	}
}
