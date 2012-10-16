<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DetalleClientes.aspx.cs" Inherits="WebSite.DetalleClientes" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style='background-color:Silver;color:#006699'>
    <form id="form1" runat="server">
    <div>
    <h1><center>Municipalidad de San Juan de Miraflores</center></h1>
    <h1>Listado de Estados de Cuentas:</h1>
    <br />
        <asp:GridView ID="gvCliente" runat="server" BackColor="White" 
            BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3" 
            AutoGenerateColumns="False" >
            <Columns>
                <asp:BoundField DataField="cliente_id" HeaderText="cliente_id" />
                <asp:BoundField DataField="cliente_idExterno" HeaderText="cliente_idExterno"></asp:BoundField>
                <asp:BoundField DataField="descripcion1" HeaderText="descripcion1"></asp:BoundField>
                <asp:BoundField DataField="descripcion2" HeaderText="descripcion2"></asp:BoundField>
                <asp:BoundField DataField="saldo" HeaderText="saldo"></asp:BoundField>
                <asp:HyperLinkField HeaderText="Editar Saldo" DataNavigateUrlFields="cliente_id" 
                    DataNavigateUrlFormatString="MantenimientoCliente.aspx?cliente_id={0}" 
                    NavigateUrl="MantenimientoCliente.aspx?cliente_id={<%= cliente_id %>}" 
                    Text="Editar" />
            </Columns>
            <FooterStyle BackColor="White" ForeColor="#000066" />
            <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
            <RowStyle ForeColor="#000066" />
            <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
            <SortedAscendingCellStyle BackColor="#F1F1F1" />
            <SortedAscendingHeaderStyle BackColor="#007DBB" />
            <SortedDescendingCellStyle BackColor="#CAC9C9" />
            <SortedDescendingHeaderStyle BackColor="#00547E" />
        </asp:GridView>
    </div>
    </form>
</body>
</html>
