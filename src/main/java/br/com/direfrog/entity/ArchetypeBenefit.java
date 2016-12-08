package br.com.direfrog.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.engine.internal.Cascade;

@Entity
public class ArchetypeBenefit implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	
	//Added by God666
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Book book;
	private String bookPage;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="archetype_id")
	private Archetype archetype;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getBookPage() {
		return bookPage;
	}

	public void setBookPage(String bookPage) {
		this.bookPage = bookPage;
	}

	public Archetype getArchetype() {
		return archetype;
	}

	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archetype == null) ? 0 : archetype.hashCode());
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((bookPage == null) ? 0 : bookPage.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArchetypeBenefit other = (ArchetypeBenefit) obj;
		if (archetype == null) {
			if (other.archetype != null)
				return false;
		} else if (!archetype.equals(other.archetype))
			return false;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (bookPage == null) {
			if (other.bookPage != null)
				return false;
		} else if (!bookPage.equals(other.bookPage))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArchetypeBenefit [id=" + id + ", name=" + name + ", description=" + description + ", book=" + book
				+ ", bookPage=" + bookPage + ", archetype=" + archetype + "]";
	}


}
