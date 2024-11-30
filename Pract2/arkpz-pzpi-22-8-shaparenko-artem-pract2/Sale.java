package com.example.SRBDlab3;

public class Sale {
    Integer saleID;
    String name;
    Integer value;

    public Integer getSaleID() {
        return saleID;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public class Sales {
        private String[] newSales;

        public String GetValueFromArray(int index){
            if (index >= newSales.length){
                return "Error";
            }
            return newSales[index];
        }

        public static void main(String[] args) {
            Sale newSale = new Sale();
            newSale.setSaleID(1924);
            newSale.setName("Laptop");
            newSale.setValue(1200);
        }

    }
}