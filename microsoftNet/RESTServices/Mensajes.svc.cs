using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace RESTServices
{
    public class Mensajes : IMensajes
    {
        public string Saludos()
        {
            string saludo = "";
            var hora = DateTime.Now.Hour;

            if (hora < 12)
                saludo = "Buenos días";
            else if (hora < 19)
                saludo = "Buenas tardes";
            else
                saludo = "Buenas noches";

            return saludo;
        }
    }
}
