<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="MantenimientoCliente.aspx.cs" Inherits="WebSite.MantenimientoCliente" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style='background-color:Silver;color:#006699'>
    <form id="form1" runat="server">
    <div>
    <h1><center>Municipalidad de San Juan de Miraflores</center></h1>
    <h1>Edición de Saldo:</h1>
    <br />
        <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>cliente_id</td>
                <td>
                    <asp:TextBox ID="txtcliente_id" runat="server" Enabled="false"></asp:TextBox></td>
            </tr>
            <tr>
                <td>Saldo</td>
                <td>
                    <asp:TextBox ID="txtsaldo" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <asp:Button ID="btnEnviar" runat="server" Text="Enviar" 
                        onclick="btnEnviar_Click" /></td>
            </tr>

            <tr>
            <td></td>
            <td>
                <asp:Button ID="btnProcesar" runat="server" Text="Procesar" 
                    onclick="btnProcesar_Click" /></td>
            </tr>
        </table>
    </div>
    </form>
</body>

</html>
