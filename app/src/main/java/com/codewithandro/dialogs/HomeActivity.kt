package com.codewithandro.dialogs

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.codewithandro.dialogs.databinding.ActivityHomeBinding
import com.google.android.material.textfield.TextInputEditText

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    //coustome dilog
    lateinit var dialog: Dialog


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resiveData = intent.getStringExtra(LogInForm.KEY)
        val tvShow =binding.tvShow

       tvShow.text =resiveData.toString() //set text to the screen

        //dilog Box Functions

        //simpleDilogBox 1
        logoutBtnDilogFun() //calling simple alertDilog Box

        //SingleItemChoice dilog 2 like-> MCQ
        feedbackDilogFunSingleItemChoice()

        //MultipalItemChoice dilog 3 like-> ListChoice
        skillsChoiceFun()

        //4 -> Custome DilogBox
        customeDialog()

    }


    //simple dilog Box -> 1

    private fun logoutBtnDilogFun() {
        //AlertDialog -> dilog 1
        binding.logoutBtn.setOnClickListener{

            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are You Sure ?")
            builder1.setIcon(R.drawable.baseline_logout_24)
            builder1.setMessage("Do you want close the App ? ")
            builder1.setPositiveButton("YES",DialogInterface.OnClickListener { dialogInterface, i ->
                //yes then Exit The App ->
                finish()
                intent= Intent(applicationContext,Day_Fifth::class.java)
                startActivity(intent)

                Toast.makeText(this,"Log Out Sucessfully",Toast.LENGTH_LONG).show()
            })

            builder1.setNegativeButton("NO",DialogInterface.OnClickListener { dialogInterface, i ->
                //no then continue the app
                Toast.makeText(this,"Log Out Canceled",Toast.LENGTH_LONG).show()
            })
            builder1.show()
        }
    }

    //DilogBox 2
    //multiple option -> single choice alert dialog box
    private fun feedbackDilogFunSingleItemChoice() {

        //create array take the options like mcq
        val options= arrayOf("Very Good","Good","Satisfied","Excellent")

        binding.feedbackBtn.setOnClickListener{
            val builder2=AlertDialog.Builder(this)
            builder2.setTitle("Enter Your App Experience ? ")
            builder2.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                //show the clicked option ->   (i)  <- the store the clicked element in i object
                Toast.makeText(this,"You Clicked On ${options[i]} ",Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("SUBMIT",DialogInterface.OnClickListener { dialogInterface, i ->
                //assignment store the clicked option in database
                //finish()
                Toast.makeText(this,"Thanks! Submit Feedback",Toast.LENGTH_LONG).show()
            })
            builder2.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"Feedback Canceled !",Toast.LENGTH_LONG).show()
            })

            builder2.show()

        }
    }

    //DilogBox 3
    //multiple option -> Multiple choice alert dialog box
    private fun skillsChoiceFun() {
        //options array
        val options = arrayOf("Kotlin","Firebase","Java","Hibernate")

        binding.skillsBtn.setOnClickListener{
            val builder3=AlertDialog.Builder(this)
            builder3.setTitle("Choice Your Skills")

            builder3.setMultiChoiceItems(options,null,DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                //show the clicked option ->   (i)  <- the store the clicked element in i object
                Toast.makeText(this,"You Clicked On ${options[i]} ",Toast.LENGTH_SHORT).show()
            })


            builder3.setPositiveButton("SUBMIT",DialogInterface.OnClickListener { dialogInterface, i ->
                //button clicked perform logic Store database options
                Toast.makeText(this,"Skills Submit !",Toast.LENGTH_LONG).show()
            })
            builder3.setNegativeButton("Decline",DialogInterface.OnClickListener { dialogInterface, i ->
                //cancled
                Toast.makeText(this,"Skills Canceled !",Toast.LENGTH_LONG).show()
            })

            builder3.show()

        }
    }


    //copyright Prajwal Jaybhaye
    /*-----------------------------------------------------------------------------------------------------------------*/
    //DilogBox 4 -> custome dialog box
    private fun customeDialog() {

        dialog = Dialog(this)
        dialog.setContentView(R.layout.coustome_dilog)//custome_dilog.xml
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_dialog))//dilog size and color corner xml drawble


        //submit And cancel button featch
        val submitCostmeDilog = dialog.findViewById<Button>(R.id.submitBtn)
        val cancleCostmeDilog = dialog.findViewById<Button>(R.id.cancelBtn)

        submitCostmeDilog.setOnClickListener {

            //featch dilog buttons submitBtn,cancelBtn
            val nameCDB = dialog.findViewById<TextInputEditText>(R.id.userName).text.toString()
            val monoCDB = dialog.findViewById<TextInputEditText>(R.id.userMo).text.toString()
            val emailCDB = dialog.findViewById<TextInputEditText>(R.id.userEmailId).text.toString()
            val massageCDB = dialog.findViewById<TextInputEditText>(R.id.massage).text.toString()

            if (nameCDB.isNotEmpty() && monoCDB.isNotEmpty() && emailCDB.isNotEmpty() && massageCDB.isNotEmpty()) {
                //Not-empty dilog box

                dialog = Dialog(this)
                dialog.setContentView(R.layout.cstome_dilog_datastored_sucessfully)

                //button featch
                val newDone = dialog.findViewById<Button>(R.id.newDone)

                newDone.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.show()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Plase Fill The Blank Fields !",
                    Toast.LENGTH_LONG
                ).show()

            }

        }

    }
}

                /*
                val costomeData = CustomeData(nameCDB, monoCDB, emailCDB, massageCDB)

                //user filled diatils
                //store database
                //connection establish
                databaseRef = FirebaseDatabase.getInstance().getReference("Users")
                //store data
                databaseRef.child("monoCDB").setValue(costomeData).addOnSuccessListener {
                    //sucessfully stored
                    dialog = Dialog(this)
                    dialog.setContentView(R.layout.cstome_dilog_datastored_sucessfully)//dialog drawble
                    //featch done button
                    val done = dialog.findViewById<Button>(R.id.done)

                    done.setOnClickListener {
                        dialog.dismiss()
                    }

                    dialog.show()
                }
            }/*.addOnFailureListener{
                    //show
                   Toast.makeText(applicationContext,"Enquiry Failed ! Try Agian",Toast.LENGTH_LONG).show()
                }
            }else{
                //create dilog box ids (doneBtn)
                //user not filled deitials

                dialog=Dialog(this)
                dialog.setContentView(R.layout.fill_coustomedilog)//fill_coustomedilog custome layout pass
                dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_dialog))//dilog size and color corner xml drawble

                //featch diloge button
                val doneBtn =dialog.findViewById<Button>(R.id.doneBtn)
                doneBtn.setOnClickListener{
                    dialog.dismiss()
                }

                dialog.show()
            }*
        cancleCostmeDilog.setOnClickListener{
            dialog.dismiss()
        }
        }
             */

        //dialog show btn
        binding.customeDilogBtn.setOnClickListener {
            dialog.show()
        }

        cancleCostmeDilog.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(applicationContext,"Enquiry Canceled !",Toast.LENGTH_LONG).show()
        }

        }

} }
        */