using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Net;
using System.IO;
using System.Web.Script.Serialization;
using RESTTests;

namespace WebSite
{
    public partial class ListadoClientes : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ListarClientes();
        }

        void ListarClientes()
        {
            HttpWebRequest req3 = (HttpWebRequest)WebRequest.Create("http://rest-coactivos.aesoluciones.cloudbees.net/rs/cliente-service/clientes.json");
            req3.Method = "GET";
            HttpWebResponse res3 = (HttpWebResponse)req3.GetResponse();
            StreamReader reader3 = new StreamReader(res3.GetResponseStream());
            string clienteJson3 = reader3.ReadToEnd();
            clienteJson3 = clienteJson3.Substring(clienteJson3.IndexOf('['));
            clienteJson3 = clienteJson3.Remove(clienteJson3.IndexOf(']') + 1);
            JavaScriptSerializer js3 = new JavaScriptSerializer();
            List<Cliente> alumnoObtenido = js3.Deserialize<List<Cliente>>(clienteJson3);

            gvCliente.DataSource = alumnoObtenido;
            gvCliente.DataBind();
        }

    }
}