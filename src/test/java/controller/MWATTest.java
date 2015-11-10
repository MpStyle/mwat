package controller;

import java.net.URL;

import static org.junit.Assert.*;

public class MWATTest {
  private MWAT obj;
  private URL viewFolderURL=getClass().getResource("/app/views/");
  private URL translationFolderURL=getClass().getResource("/app/languages/");
  private URL outputFolderURL=getClass().getResource("/app/output/");

  @org.junit.Before
  public void setUp() throws Exception {
    obj=new MWAT(viewFolderURL.getPath(),translationFolderURL.getPath(),outputFolderURL.getPath());
  }

  @org.junit.After
  public void tearDown() throws Exception {

  }

  @org.junit.Test
  public void testStart() throws Exception {
    obj.start();
    assertTrue(true);
  }
}