package com.example.recycleviewapp


import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recycleviewapp.databinding.ActivityMainBinding
import com.example.recycleviewapp.StateAdapter.OnStateClickListener


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var states = ArrayList<State>()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val recyclerView = binding.list
        setInitialData()


        val stateClickListener: OnStateClickListener = object : OnStateClickListener {
            override fun onStateClick(state: State?, position: Int) {
                Toast.makeText(
                    applicationContext, "Был выбран пункт " + state!!.surname,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


// создаем адаптер
        val adapter = StateAdapter(this,R.layout.list_item,states,stateClickListener)
// устанавливаем для списка адаптер
        recyclerView.adapter = adapter
        val bestForward = states.maxByOrNull { it.goals }
        binding.best.text = "Лучший форвард: ${bestForward?.surname}, забил ${bestForward?.goals} голов за ${bestForward?.games} игр."
    }
    private fun setInitialData() {
        states.add(State("Роберт Левандовски","Нападающий",32,4,7))
        states.add(State("Килиан Мбаппе","Нападающий",22,3,10))
        states.add(State("Карим Бензема","Нападающий",27,2,4))
    }

}
