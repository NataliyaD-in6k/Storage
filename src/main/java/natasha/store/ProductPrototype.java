    package natasha.store;

    import java.math.BigDecimal;

    public class ProductPrototype {
        private String name;
        private BigDecimal price;
        private Category category;

        public ProductPrototype(String name, BigDecimal price, Category category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }
    }
