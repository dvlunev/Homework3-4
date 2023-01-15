package me.lunev.homework34.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Ingredient {

    private String name;
    private int amount;
    private String unitMeasurement;

    private static int number = 1;

    public Ingredient() {
    }

    public Ingredient(String name, int amount, String unitMeasurement) {
        setName(name);
        setAmountIngredients(amount);
        setUnitMeasurement(unitMeasurement);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isNullBlankOrEmpty(name)) {
            name = "Ингредиент " + number++;
        }
        this.name = name;
    }

    public int getAmountIngredients() {
        return amount;
    }

    public void setAmountIngredients(int amount) {
        if (amount <= 0) {
            amount = 1;
        }
        this.amount = amount;
    }

    public String getUnitMeasurement() {
        return unitMeasurement;
    }

    public void setUnitMeasurement(String unitMeasurement) {
        if (StringUtils.isNullBlankOrEmpty(unitMeasurement)) {
            unitMeasurement = "По вкусу";
        }
        this.unitMeasurement = unitMeasurement;
    }
}
