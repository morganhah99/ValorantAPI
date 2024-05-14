package com.example.valorantapi.ui.agent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.valorantapi.R
import com.example.valorantapi.data.model.agent.DataModel
import com.example.valorantapi.databinding.AgentElementBinding

class AgentListAdapter(
    private val agentList:List<DataModel?>?
):RecyclerView.Adapter <AgentListAdapter.MyViewHolder>() {
        inner class MyViewHolder(itemView:View ):ViewHolder(itemView){
            private val binding = AgentElementBinding.bind(itemView)

            fun updateUI (agentItemModel: DataModel?){
                //handle UI changes based on current state

                binding.apply {
                    //add ui elements to add to agent element card - Pass pic and name
                    Glide.with(itemView.context).load(agentItemModel?.displayIcon).placeholder(R.drawable.person_icon_new).into(ivAgentPic)
                    tvAgentName.text = agentItemModel?.displayName
                }
            }
    }

    override fun getItemCount(): Int = agentList?.size?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.agent_element, parent,false))

    }

    override fun onBindViewHolder(holder: AgentListAdapter.MyViewHolder, position: Int) {
//        if (agentList != null && position >= 0 && position < agentList.size) {
////            holder.updateUI(agentList.get(position))
//            val agent = agentList[position]
//            // Update the UI with the agent data
//            if (agent != null) {
//                holder.updateUI(agent)
//            }
//        }


        holder.updateUI(agentList?.get(position))
    }




}