using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net;
using System.IO;
using System.Web.Script.Serialization;

namespace RESTTests
{
    [TestClass]
    public class AlumnosText
    {
        [TestMethod]
        public void CRUDTest()
        {
            
            //Prueba de creación de alumno por HTTP POST

            //string postdata = "{\"Codigo\":\"003\",\"Nombre\":\"Sofia\"}"; //JSON
            //byte[] data = Encoding.UTF8.GetBytes(postdata);
            //HttpWebRequest req = (HttpWebRequest)WebRequest.Create("http://localhost:27695/Alumnos.svc/Alumnos");
            //req.Method = "POST";
            //req.ContentLength = data.Length;
            //req.ContentType = "application/json";
            //var reqStream = req.GetRequestStream();
            //reqStream.Write(data, 0, data.Length);
            //var res = (HttpWebResponse)req.GetResponse();
            //StreamReader reader = new StreamReader(res.GetResponseStream());
            //string alumnoJson = reader.ReadToEnd();
            //JavaScriptSerializer js = new JavaScriptSerializer();
            //Alumno alumnoCreado = js.Deserialize<Alumno>(alumnoJson);
            //Assert.AreEqual("002", alumnoCreado.Codigo);
            //Assert.AreEqual("Sofia", alumnoCreado.Nombre);
    
            
            //Prueba de obtención de alumno por HTTP GET

            //HttpWebRequest req2 = (HttpWebRequest)WebRequest.Create("http://localhost:27695/Alumnos.svc/Alumnos/001");
            //req2.Method = "GET";
            //HttpWebResponse res2 = (HttpWebResponse)req2.GetResponse();
            //StreamReader reader2 = new StreamReader(res2.GetResponseStream());
            //string alumnoJson2 = reader2.ReadToEnd();
            //JavaScriptSerializer js2 = new JavaScriptSerializer();
            //Alumno alumnoObtenido = js2.Deserialize<Alumno>(alumnoJson2);
            //Assert.AreEqual("001", alumnoObtenido.Codigo);
            //Assert.AreEqual("Juan Peres", alumnoObtenido.Nombre);
          
            
            /*Prueba de modificación de alumno vía HTTP PUT*/

            /*
      string postdata = "{\"Codigo\":\"u201200003\",\"Nombre\":\"Sofia\"}"; //JSON
           byte[] data = Encoding.UTF8.GetBytes(postdata);
           HttpWebRequest req = (HttpWebRequest)WebRequest.Create("http://localhost:27695/Alumnos.svc/Alumnos");
           req.Method = "PUT";
           req.ContentLength = data.Length;
           req.ContentType = "application/json";
           var reqStream = req.GetRequestStream();
           reqStream.Write(data, 0, data.Length);
           var res = (HttpWebResponse)req.GetResponse();
           StreamReader reader = new StreamReader(res.GetResponseStream());
           string alumnoJson = reader.ReadToEnd();
           JavaScriptSerializer js = new JavaScriptSerializer();
           Alumno alumnoCreado = js.Deserialize<Alumno>(alumnoJson);
           Assert.AreEqual("u201200003", alumnoCreado.Codigo);
           Assert.AreEqual("Sofia", alumnoCreado.Nombre);
 

           //Prueba de eliminación de alumno vía HTTP DELETE
 /*
          HttpWebRequest req2 = (HttpWebRequest)WebRequest.Create("http://localhost:27695/Alumnos.svc/Alumnos/4");
          req2.Method = "DELETE";

          HttpWebResponse res2 = (HttpWebResponse)req2.GetResponse();
          StreamReader reader2 = new StreamReader(res2.GetResponseStream());
          string alumnoJson2 = reader2.ReadToEnd();
           */

            /*
           JavaScriptSerializer js2 = new JavaScriptSerializer();
           Alumno alumnoObtenido = js.Deserialize<Alumno>(alumnoJson2);
           Assert.AreEqual("u201200003", alumnoCreado.Codigo);
           Assert.AreEqual("Sofia", alumnoCreado.Nombre);
           */


            /*Prueba de listado de alumnos por HTTP GET*/
            
            //HttpWebRequest req3 = (HttpWebRequest)WebRequest.Create("http://localhost:27695/Alumnos.svc/Alumnos");
            //req3.Method = "GET";
            //HttpWebResponse res3 = (HttpWebResponse)req3.GetResponse();
            //StreamReader reader3 = new StreamReader(res3.GetResponseStream());
            //string alumnoJson3 = reader3.ReadToEnd();
            //JavaScriptSerializer js3 = new JavaScriptSerializer();
            //List<Alumno> alumnoObtenido = js3.Deserialize<List<Alumno>>(alumnoJson3);
            //Assert.AreEqual(alumnoObtenido.Count, 2);


            //


            HttpWebRequest req3 = (HttpWebRequest)WebRequest.Create("http://rest-coactivos.aesoluciones.cloudbees.net/rs/cliente-service/clientes.json");
            req3.Method = "GET";
            HttpWebResponse res3 = (HttpWebResponse)req3.GetResponse();
            StreamReader reader3 = new StreamReader(res3.GetResponseStream());
            string clienteJson3 = reader3.ReadToEnd();
            clienteJson3 = clienteJson3.Substring(clienteJson3.IndexOf('['));
            clienteJson3 = clienteJson3.Remove(clienteJson3.IndexOf(']') + 1);
            JavaScriptSerializer js3 = new JavaScriptSerializer();
            List<Cliente> alumnoObtenido = js3.Deserialize<List<Cliente>>(clienteJson3);

            //Assert.AreEqual(alumnoObtenido.Count, 10);
            Assert.AreEqual(alumnoObtenido[1].descripcion1, "EMPRESA SAN FERNANDO S.A.");


        }
    }
}
