package uk.ac.ncl.student.siddique.cw.part1;

import java.util.Objects;

public final class Module {

    private final String moduleCode;
    private final String moduleName;
    private final int semester;
    private final int credits;


    private Module(String moduleCode, String moduleName, int semester, int credits) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.semester = semester;
        this.credits = credits;

    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getSemester() {
        return semester;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Module module = (Module) o;
        return  Objects.equals(moduleCode, module.moduleCode) && Objects.equals(moduleName, module.moduleName) &&  semester == module.semester && credits == module.credits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleCode, moduleName, semester, credits);
    }

    public static Module valueOf(String module) {

        if (module == null) throw new IllegalArgumentException("module is null");

        final String[] parts = module.split(", ");

        return new Module (parts[0], parts[1],Integer.valueOf(parts[2]) , Integer.valueOf(parts[3]));

    }

}



