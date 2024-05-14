package pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import pages.components.block.BlockHeader;
import testdata.Blocks;


public class BlockPage {
  
  public final BlockHeader header = new BlockHeader();
  
  @Step("Открываем главную страницу ЖК [{block.name}]")
  public void open(Blocks block) {
    Selenide.open("/object/%s".formatted(block.guid));
  }
}