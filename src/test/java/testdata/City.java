package testdata;

public enum City {
  
  MOSCOW("Москва", "msk", "5a5cb42159042faa9a218d04"),
  SPB("Санкт-Петербург", "", "58c665588b6aa52311afa01b"),
  NSK("Новосибирск", "nsk", "618120c1a56997000866c4d8");
  
  public final String name;
  public final String urlPrefix;
  public final String id;
  
  City(String name, String urlPrefix, String id) {
    
    this.name = name;
    this.urlPrefix = urlPrefix;
    this.id = id;
    
  }
}
