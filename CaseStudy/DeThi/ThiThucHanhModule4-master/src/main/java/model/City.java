package model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Max(20)
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @NotNull
    @Min(value = 1,message = "Cần nhập vào số dương")
    private float  area;
    @NotNull
    @Min(value = 1,message = "Cần nhập vào số dương")
    private double population;
    @NotNull
    @Min(value = 1, message = "Cần nhập vào số dương")
    private float gdp;
    @Size(min = 10, max = 50,message = "Mô tả cần lớn hơn 20 ký tự")
    private String description;

    public City(Long id, String name, Country country, float area, double population, float gdp, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City(Long id, String name, float area, double population, float gdp, String description) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
