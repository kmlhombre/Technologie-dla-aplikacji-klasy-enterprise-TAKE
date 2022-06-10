/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.complaintsclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author osakk
 */
public class ComplaintsClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String count = client.target("http://localhost:8080/Complaints/resources/complaints/count")
        .request(MediaType.TEXT_PLAIN)
        .get(String.class);

        System.out.println("Count: " + count);
        
        String complaints = client.target("http://localhost:8080/Complaints/resources/complaints")
            .request(MediaType.APPLICATION_JSON)
            .get(String.class);
        JSONArray temp = new JSONArray(complaints);
        System.out.println(temp);
        for (int i=0; i<temp.length(); i++) {
            JSONObject object = temp.getJSONObject(i);
            if(object.get("status").equals("open")) {
                String open_complaint = client.target("http://localhost:8080/Complaints/resources/complaints/" + object.get("id"))
                    .request(MediaType.APPLICATION_JSON)
                    .get(String.class);
                System.out.println(open_complaint);
                JSONObject temp2 = new JSONObject(open_complaint);
                temp2.put("status", "closed");
                WebTarget target = client.target("http://localhost:8080/Complaints/resources/complaints/"+temp2.get("id"));
                String response = target.request(MediaType.APPLICATION_JSON)
                        .accept(MediaType.TEXT_PLAIN_TYPE)
                        .put(Entity.json(temp2.toString()), String.class);
                System.out.println(response);
                
                String open_complaints = client.target("http://localhost:8080/Complaints/resources/complaints?status=open")
                    .request(MediaType.APPLICATION_JSON)
                    .get(String.class);
                System.out.println(open_complaints);
                break;
            }
        }
        client.close();
    }
}
