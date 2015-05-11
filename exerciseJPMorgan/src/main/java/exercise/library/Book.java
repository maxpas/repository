package exercise.library;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Massimo
 * Representation of a book in a library.
 */
public class Book implements Serializable
{
	private static final long serialVersionUID = -3632558195114182453L;
	private String isbn;
    private String title;
    private String description;

    /**
     * Constructor accepting parameters.
     * @param isbn
     * @param title
     * @param description
     */
    public Book(String isbn, String title, String description)
    {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
    }

    public String getDescription()
    {
    	return description;
    }

    /**
     * Extracts a short description comprised of the specified number of words.
     * @param number of words
     * @param spacesToBlank - option to convert any whitespace [\t\n\x0B\f\r] to a single blank in the description
     * @return short description
     */
    public String getDescription(int number, boolean spacesToBlank)
    {
    	if (description == null || description.length() == 0) {
			return description;
		}
    	StringBuilder summary = new StringBuilder();
    	int wordCounter = 0;
    	if (spacesToBlank) {
        	String [] tokens = description.split("[\\s]");
            for(String s:tokens){
            	if (wordCounter < number) {
    				summary.append(s).append(' ');
    				wordCounter++;
    			} else {
    				break;
    			}
            }
        	summary.deleteCharAt(summary.length()-1);
        	if (tokens.length > number) {
        		summary.append("...");
        	}
		} else {
	    	String regex = "\\S+\\s*";
	    	Pattern pattern = Pattern.compile(regex);
	    	Matcher matcher = pattern.matcher(description);
	    	// check all occurrences
	        while (matcher.find()) {
	          if (wordCounter < number) {
	              summary.append(matcher.group());
	              wordCounter++;
	          } else {
	        	  summary.deleteCharAt(summary.length()-1);
	        	  summary.append("...");
	        	  break;
	          }
	        }
		}
            	
    	return summary.toString();
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
            // if deriving: appendSuper(super.hashCode()).
            append(isbn).
            append(title).
            append(description).
            toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Book))
            return false;
        if (obj == this)
            return true;

        Book rhs = (Book) obj;
        return new EqualsBuilder().
            // if deriving: appendSuper(super.equals(obj)).
            append(isbn, rhs.isbn).
            append(title, rhs.title).
            append(description, rhs.description).
            isEquals();
    }
}
