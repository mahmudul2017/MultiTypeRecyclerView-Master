package ltd.apps.multityperecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recyclerview.*
import ltd.apps.multityperecyclerview.adapter.MultiRecyclerAdapter
import ltd.apps.multityperecyclerview.model.UserModel

class MultiRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val dataList = ArrayList<UserModel>()
        dataList.add(UserModel(1, "1. Hi! I am in View 1", ""))
        dataList.add(UserModel(2, "2. Hi! I am in View 2", "Flutter"))
        dataList.add(UserModel(3, "3. Hi! I am in View 3", ""))
        dataList.add(UserModel(4, "4. Hi! I am in View 4", "Kotlin"))
        dataList.add(UserModel(5, "5. Hi! I am in View 5", ""))
        dataList.add(UserModel(6, "6. Hi! I am in View 6", "Dart"))
        dataList.add(UserModel(7, "7. Hi! I am in View 7", ""))
        dataList.add(UserModel(8, "8. Hi! I am in View 8", "Java"))
        dataList.add(UserModel(9, "9. Hi! I am in View 9", ""))
        dataList.add(UserModel(10, "10. Hi! I am in View 10", "Android"))
        dataList.add(UserModel(11, "11. Hi! I am in View 11", ""))
        dataList.add(UserModel(12, "12. Hi! I am in View 12", "IOS"))

        val adapter = MultiRecyclerAdapter(dataList, object: MultiRecyclerAdapter.OnItemClickListener{
            override fun onItemClick(user: UserModel?) {
               Toast.makeText(this@MultiRecyclerActivity, "${user?.userId} clicked", Toast.LENGTH_SHORT).show()
            }
        })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}