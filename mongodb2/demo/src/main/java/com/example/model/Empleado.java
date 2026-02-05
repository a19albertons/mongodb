package com.example.model;

/**
 * Modelo de empleado.
 */
public class Empleado {
    private int emp_no;
    private String nombre;
    private int dep;
    private int salario;
    private String fechaalta;
    private String oficio;
    private int comision;

    /**
     * getter numero de empleado
     * 
     * @return devuelve el numero de empleado
     */
    public int getEmp_no() {
        return emp_no;
    }

    /**
     * setter numero de empleado
     * 
     * @param emp_no numero de empleado
     */
    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    /**
     * getter nombre empleado
     * 
     * @return devuelve el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setter nombre empleado
     * 
     * @param nombre nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter departamento empleado
     * 
     * @return devuelve el departamento del empleado
     */
    public int getDep() {
        return dep;
    }

    /**
     * setter departamento empleado
     * 
     * @param dep departamento del empleado
     */
    public void setDep(int dep) {
        this.dep = dep;
    }

    /**
     * getter salario empleado
     * 
     * @return devuelve el salario del empleado
     */
    public int getSalario() {
        return salario;
    }

    /**
     * setter salario empleado
     * 
     * @param salario salario del empleado
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }

    /**
     * getter fecha alta empleado
     * 
     * @return devuelve la fecha de alta del empleado
     */
    public String getFechaalta() {
        return fechaalta;
    }

    /**
     * setter fecha alta empleado
     * 
     * @param fechaalta fecha de alta del empleado
     */
    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }

    /**
     * getter oficio
     * 
     * @return devuelve el oficio
     */
    public String getOficio() {
        return oficio;
    }

    /**
     * setter oficio
     * 
     * @param oficio nombre del oficio
     */
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    /**
     * getter comision
     * 
     * @return devuelve la comision
     */
    public int getComision() {
        return comision;
    }

    /**
     * setter comision
     * @param comision establece la comision
     */
    public void setComision(int comision) {
        this.comision = comision;
    }

    /**
     * Constructor de la clase Empleado
     * 
     * @param emp_no    numero de empleado
     * @param nombre    nombre del empleado
     * @param dep       departamento del empleado
     * @param salario   salario del empleado
     * @param fechaalta fecha de alta del empleado
     * @param oficio    oficio del empleado
     * @param comision  comision del empleado
     */
    public Empleado(int emp_no, String nombre, int dep, int salario, String fechaalta, String oficio, int comision) {
        this.emp_no = emp_no;
        this.nombre = nombre;
        this.dep = dep;
        this.salario = salario;
        this.fechaalta = fechaalta;
        this.oficio = oficio;
        this.comision = comision;
    }

}
