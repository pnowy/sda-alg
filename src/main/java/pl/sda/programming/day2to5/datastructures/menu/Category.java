package pl.sda.programming.day2to5.datastructures.menu;

import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Category {

    private String id;
    private String name;
    private Category parent;
    private int level;
    private List<Category> children;

    private Category() {
        this.id = UUID.randomUUID().toString();
        this.children = new ArrayList<>();
    }

    public Category(String name) {
        this();
        this.parent = null;
        this.name = name;
        this.level = 0;
    }

    private Category(String name, Category parent) {
        this();
        this.name = name;
        this.parent = parent;
        this.level = parent.level + 1;
    }

    public Category addSubcategory(String name) {
        Category child = new Category(name, this);
        this.children.add(child);
        return child;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public void print() {
        System.out.println(Strings.repeat(" ", this.level * 3) + this.name);
        for (Category child : children) {
            child.print();
        }
    }

}
