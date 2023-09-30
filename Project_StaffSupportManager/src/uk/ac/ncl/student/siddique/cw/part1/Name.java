package uk.ac.ncl.student.siddique.cw.part1;


public final class Name {
        private String firstName;
        private String lastName;

    Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the first name
     */
    public String getFirstName() { return firstName; }


    /**
     * @return the last name
     */
    public String getLastName() { return lastName; }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Name))
            return false;

        final Name name = (Name) obj;
        return firstName.equals(name.firstName)
                && lastName.equals(lastName);
    }



    @Override
    public int hashCode() {
        int hc = 7;

        hc = 17 * hc + firstName.hashCode();

        return 17 * hc + lastName.hashCode();
    }



    /**
     * Returns a string representation of a name
     * The string representation is a first name and last name separated
     * by a space character
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }



    /**
     * @param name
     * @return an instance of a Name corresponding to the given
     * string
     * @throws IllegalArgumentException if name is null
     */
    public static Name valueOf(String name) {
        if (name == null) throw new IllegalArgumentException("name is null");
        final String[] parts = name.split(" ");
        return new Name (parts[0], parts[1]);
    }

}
