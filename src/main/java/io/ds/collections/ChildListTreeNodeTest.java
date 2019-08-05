//package io.ds.collections;
//
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.fail;
//
//import org.junit.Test;
//
///**
// * Unit test for the tree nodes implemented with the child list.
// */
//public class ChildListTreeNodeTest {
//
//  @Test
//  public void testEmptyTree() {
//    SimpleTreeNode<String> root = new ChildListTreeNode<String>("root");
//    assertEquals(root.getData(), "root");
//    assertNull(root.getParent());
//    assertEquals(root.getChildren().size(), 0);
//  }
//
//  @Test
//  public void testSomeInserts() {
//    SimpleTreeNode<String> root = new ChildListTreeNode<String>("root");
//    root.setData("animal");
//    assertEquals(root.getData(), "animal");
//    root.insertChildAt(0, new ChildListTreeNode<String>("bird"));
//    assertEquals(root.getChildren().size(), 1);
//    SimpleTreeNode<String> bird =
//        root.getChildren().get(0);
//    bird.insertChildAt(0, new ChildListTreeNode<String>("sparrow"));
//    try {
//      bird.insertChildAt(2, new ChildListTreeNode<String>("raven"));
//      fail();
//    } catch (Exception e) {
//      assertTrue(true);
//    }
//    bird.insertChildAt(0, new ChildListTreeNode<String>("raven"));
//    bird.insertChildAt(2, new ChildListTreeNode<String>("finch"));
//    bird.insertChildAt(1, new ChildListTreeNode<String>("cardinal"));
//    bird.insertChildAt(4, new ChildListTreeNode<String>("hawk"));
//    bird.insertChildAt(2, new ChildListTreeNode<String>("cassowary"));
//    SimpleTreeNode sparrow = (SimpleTreeNode)bird.getChildren().get(3);
//    assertEquals(sparrow.getData(), "sparrow");
//    sparrow.removeFromParent();
//    assertEquals(bird.getChildren().size(), 5);
//  }
//
//  // TODO: This tester is nowhere near finished.
//}