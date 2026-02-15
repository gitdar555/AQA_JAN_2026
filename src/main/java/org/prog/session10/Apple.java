package org.prog.session10;

public class Apple {

    private String model;
    private String color;

    public Apple(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {

        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        if (obj instanceof Apple other) {

            if (other.model == null || other.color == null) {
                throw new MyPhoneException("Model or color is null");
            }

            return model.equals(other.model) &&
                    color.equals(other.color);
        }

        return false;
    }

    @Override
    public int hashCode() {

        if (model == null || color == null) {
            throw new MyPhoneException("Model or color is null");
        }

        return (model + color).hashCode();
    }
}
