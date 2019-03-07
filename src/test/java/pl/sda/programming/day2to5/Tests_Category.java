package pl.sda.programming.day2to5;

import org.junit.jupiter.api.Test;
import pl.sda.programming.day2to5.tasks.menu.Category;

class Tests_Category {

    @Test
    void buildCategoryMenu() {
        Category root = new Category("Kategoria główna");
        Category engines = root.addSubcategory("Engines");
        engines.addSubcategory("Gasoline");
        engines.addSubcategory("Diesel");
        Category tires = root.addSubcategory("Opony");
        tires.addSubcategory("Michelin");
        tires.addSubcategory("Continental");
        tires.addSubcategory("Dunlop");


        root.print();
    }
}
