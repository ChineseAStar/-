<xsl:stylesheet
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  version="1.0" >

<xsl:template match="/">
 <html>
			<body>
				<h2 align="center">通讯录</h2>
				<table border="1">
					<thead>
						<tr>
								<th>Name</th>
								<th>Address</th>
								<th>Latitude</th>
								<th>Longitude</th>
								<th>Phone</th>
								<th>Description</th>
						</tr>
					</thead>
					<tbody>
						<xsl:apply-templates select="contacts/contact"/>					
					</tbody>
				</table>
			</body>
		</html>
</xsl:template>

<xsl:template match="contact">
		<tr>			
			<td>
				<xsl:value-of select="name/first"/>
				<xsl:value-of select="name/middle"/>
				<xsl:value-of select="name/last"/>
			</td>
			<td>
			<xsl:value-of select="location/address"/>
			</td>
			<td>
			<xsl:value-of select="location/latitude"/>
			</td>
			<td>
			<xsl:value-of select="location/longitude"/>
			</td>
			<td>
			<xsl:value-of select="phone"/>
			</td>
			<td>
			<xsl:value-of select="description"/>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>

