package com.adrianjaylopez.webstore.dao;

/**
 * This class represents the categories that the item belongs to.
 * @author Adrian J Lopez
 * @since <pre>6/21/15</pre>
 * @version 1.0
 */
//@Entity
public class Categories {

    //declare variables
    //@Id
    //@GeneratedValue
    private Long id;

    private String category;

    /**
     * Method to get the category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method to set the category
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * toString method to show the id and the associated category
     * @return id and category
     */
    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category='" + category + '\'' +
                '}';
    }
}
