OneLineList
========
Create an entire recycler view list with just one line of code and a few annotations

##A Quick Example

Bind data to view with annotations

```java
public class Data {
  @Text String title;
  @Image(resourceName="image") String url;
}
```

Example of creating a list in the onCreate method of an Activity

```java
OneLineList<Data> oneLineList = new OneLineList<>(Data.class, dataList, recyclerView, R.layout.row, this);
```

##Anotations

Use annotations to select the fields in your data class that you wish to bind 
to the row layout. OneLineList will match the field name with the resource id 
from the row layout you provide and present the field value based on the type of
the view.

```java
@Text String title;
```

This line tells OneLineList to find a TextView with id title and set it's text to the
value of the field title.

Every annotation also contains a method resourceName that can be used to select 
a view resource id that is not the same as the field name. 

```java
@Text(resourceName="textViewTitle") String title;
@Text(resourceName="textViewContent") String content;
```

Every annotation represents a specific binder. OneLineList library contains many 
different binders that can be used to bind data to different types of views, or 
to set view properties based on the field data or position in list.

##Binders

Binders can only be used for views they were designed for and for specific data types. 

####Text Binder
Text binder can only be used to bind data of type String to TextViews.

```java
@Text String title;
```

It uses the setText method to set text to TextView


####Image Binder
Image binder binds to an ImageView and requires an url of type String

```java
@Image String url;
```

Image binder is used when you need to download an image from an url and show it in the ImageView.
It uses the Glide library to download and show images.


####CheckBox Binder
CheckBox Binder binds data of type boolean to CheckBox view and sets checked status, 
based on the boolean data.

```java
@CheckBox boolean url;
```

It also writes data back to the field, if the checked status of the CheckBox changes

####TextBold Binder
TextBold Binder binds to TextView and accepts data of type boolean 

```java
@TextBold(resourceName="title") boolean unread;
```

It will set the TextView Typeface setting to bold if the field is true or to normal if field is false

####BoldOnEven Binder
TextBold Binder binds to TextView and does not use the field data 

```java
@BoldOnEven
@Text String title;
```

Since it does not bind data to TextView, it must be used with the Text Binder. It will use the position
value to set the selected TextView Typeface to bold for all the even rows.

##Creating The List

To create a RecycleViewAdapter and generate the ViewHolder for your data class, you only need to write one line of code.
Create an instance of the OneLineList and pass in the required parameteres. 

```java
OneLineList<Data> oneLineList = new OneLineList<>(Data.class, dataList, recyclerView, R.layout.row, this);
```

You need to pass in a class type of your Data class that holds the data you wish to show in the recycler view.
You also need to pass in an ArrayList with the actual data, layout for the row and a context.

##Making Your Life Even Easier

You can easily add an onItemClickListener to the OneLineList. Simply register the onItemClickListener
```java
oneLineList.setOnItemClickListener(new OnItemClickListener() {
  @Override
  public void onItemClickListener(int position) {
  }
});
```


##Extending Functionality
Functionality of this library can be easily extended by creating new Binders. 

First you need to create an annotation that will be used to select your new Binder.

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    String resourceName() default "";
}
```

It is required to use resourceName for the method name in any OneLineList annotation. Any other method 
will be ignored.

After that you create a new class that extends the Binder class.

```java
public class CustomBinder extends Binder<String> {
    
    @Override
    public Class<? extends Annotation> getAnnotationType() {
        return CustomAnnotation.class;
    }

    @Override
    protected void bindDataToView(String data) {
      //Implement new functionality
      ((TextView)view).setTextColor(Color.parseColor(data));
    }
}
```
BindDataToView method will be called when the recycler view will be trying to fill rows with data. Data parameter
is the value of the field where the annotation is added. View is already set and accessible. You can also access
the annotated field, context and position inside the list.

In the end you need to pass your CustomBinder to the OneLineList.

```java
OneLineList<Data> oneLineList = new OneLineList<>(Data.class, dataList, recyclerView, R.layout.row, this);
oneLineList.addBinder(new CustomBinder());
```

