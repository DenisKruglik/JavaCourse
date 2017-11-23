package com.example.notepadby.lesson14;

import java.util.ArrayList;

/**
 * Created by NotePad.by on 22.11.2017.
 */

public class Data {
    public static ArrayList<Article> articles = new ArrayList<>();

    static {
        articles.add(new Article("Article 1", "Since Comparable is implemented by the same class whose objects are sorted so it binds you with that sorting logic which is ok in most of the cases but in case you want to have more than way of sorting your class objects you should use comparators. Read more about them here:"));
        articles.add(new Article("Article 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida molestie vestibulum. Ut lacinia elit vel bibendum fermentum. Sed eget enim lorem. Fusce eu faucibus massa. Maecenas vitae erat ut quam suscipit lacinia sit amet id lacus. Nunc non ipsum sapien. Duis gravida in ipsum id luctus. Sed et iaculis neque. Maecenas mattis a odio non molestie. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;"));
        articles.add(new Article("Article 3", "Nam fermentum sodales arcu sit amet congue. Proin laoreet dolor sit amet aliquam ornare. Integer malesuada tristique accumsan. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Etiam sollicitudin risus vitae tortor gravida fringilla. Mauris placerat vitae urna at faucibus. Donec mauris est, ultrices ac tortor at, venenatis commodo urna. Duis accumsan ipsum diam, vel viverra turpis facilisis vitae. Cras lobortis ac nisi vel euismod. Duis porttitor tellus lorem, et fringilla sem rutrum sed."));
    }
}
