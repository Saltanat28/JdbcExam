package peaksoft.model;

public class Restaurant {
  private   Long id;
  private String name;
  private String address;
  private int openingYear;

  public Restaurant() {
  }

  public Restaurant(Long id, String name, String address, int openingYear) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.openingYear = openingYear;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getOpeningYear() {
    return openingYear;
  }

  public void setOpeningYear(int openingYear) {
    this.openingYear = openingYear;
  }

  @Override
  public String toString() {
    return "Restaurant" +
            "id" + id +
            ", name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", openingYear=" + openingYear ;
  }
}
