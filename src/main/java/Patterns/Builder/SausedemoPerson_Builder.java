package Patterns.Builder;

public class SausedemoPerson_Builder {
    private String firstName;
    private String lastName;
    private String zipCode;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String  getZipCode() {
        return zipCode;
    }

    public static class Builder {
        private SausedemoPerson_Builder personBuilder;

        public Builder() {
            personBuilder = new SausedemoPerson_Builder();
        }

        public Builder withFirstName(String firstName) {
            personBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            personBuilder.lastName = lastName;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            personBuilder.zipCode = zipCode;
            return this;
        }

        public SausedemoPerson_Builder built() {
            return personBuilder;
        }
    }
}
