### Simple Generic Recyclerview Adapter

This Library highly inspired by : [This Repository](https://github.com/LeoDroidCoder/generic-adapter)

Get it on jitpack :

Add this to your Build.Gradle file

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

and insert to your App level Build.Gradle

    dependencies {
	        compile 'com.github.nooballday:genericrecyclerview-adapter:1.0.0'
	}

### How to use it

Create 2 classes :

 - YourAdapterClass
 - YourViewHolderClass

#### In your Adapter class

```java
public class SampleAdapter extends GenericRecyclerViewAdapter<Model, OnRecyclerObjectClickListener<Model>, SampleViewHolder> {
    public SampleAdapter(Context _context) {
        super(_context);
    }

    @Override
    public SampleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
          return new UserViewHolder(
          inflate(android.R.layout.simple_list_item_1, parent));
    }
}
```

#### ViewHolder Class

```java
public class UserViewHolder extends BaseViewHolder<Model, OnRecyclerObjectClickListener<Model>> {

    @BindView(android.R.id.text1)
    TextView mText;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBind(UserModel item, @Nullable OnRecyclerObjectClickListener<UserModel> listener) {
        mText.setText(item.getTitle());

        /**
         * add listener to your itemView you can add anyview you wish to add click listener
         */
        if (listener != null){
            itemView.setOnClickListener(v -> listener.onItemClicked(item));
        }
    }
}
```

#### In your activity or fragment

```java
public class MainActivity extends BaseActivity implements OnRecyclerObjectClickListener<UserModel> {
  @Override
    protected void onCreate(Bundle savedInstanceState) {
	RecyclerView mRv = findViewById(R.id.rvUsers);
        SampleAdapter adapter = new UserAdapter(this);
        adapter.setListener(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(adapter);
        adapter.setItems(users);
	
    }
    
    /**
     * Handle click from recyclerview
     * @param item
     */

    @Override
    public void onItemClicked(UserModel item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    }

}
```

### That's it, let me know if you have any trouble or if there is any issue at 

## *achmadnaufalsyafiq@gmail.com*
