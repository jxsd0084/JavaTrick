package bj.hmkcode.castor_xml_object.vo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Article {

	private String         title;
	private String         url;
	private List< String > categories;
	private List< String > tags;

	public void addCategory( String category ) {

		if ( this.categories == null ) {
			this.categories = new LinkedList< String >();
		}
		this.categories.add( category );
	}

	public void addTag( String tag ) {

		if ( this.tags == null ) {
			this.tags = new LinkedList< String >();
		}
		this.tags.add( tag );
	}

	@Override
	public String toString() {

		return "Article [\n title=" +
		       this.title + ",\n url=" +
		       this.url + ",\n categories=" +
		       this.categories + ",\n tags=" +
		       this.tags + "\n]";
	}

	public String getTitle() {

		return title;
	}

	public void setTitle( String title ) {

		this.title = title;
	}

	public String getUrl() {

		return url;
	}

	public void setUrl( String url ) {

		this.url = url;
	}

	public List< String > getCategories() {

		return categories;
	}

	public void setCategories( List< String > categories ) {

		this.categories = categories;
	}

	public List< String > getTags() {

		return tags;
	}

	public void setTags( List< String > tags ) {

		this.tags = tags;
	}
}
