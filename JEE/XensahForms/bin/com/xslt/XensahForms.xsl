<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns="http://www.w3.org/2000/svg">

	<xsl:output method="xml" version="1.0" indent="yes"
		encoding="UTF-8" standalone="no" doctype-public="-//W3C//DTD SVG 1.1//EN"
		doctype-system="http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"
		media-type="image/svg" />

	<xsl:template match="/">
		<svg xmlns="http://www.w3.org/2000/svg" width="100%" height="100%">
			<xsl:for-each select="plan/figure">

				<xsl:if test="@type='circle'">


					<xsl:variable name="cx" select="cx" />

					<xsl:variable name="name" select="name" />

					<xsl:variable name="cy" select="cy" />

					<xsl:variable name="r" select="r" />

					<xsl:if test=" $r &lt; $cx  and $r &lt; $cy ">

						<!-- la cercle -->
						<circle cx="{cx*37}" cy="{cy*37}" r="{r*37}" stroke="{color}"
							stroke-width="4" fill="transparent" />

						<!-- le centre -->
						<circle cx="{cx*37}" cy="{cy*37}" r="3" fill="black" />

						<!-- la line qui represente le rayon -->
						<line x1="{cx*37 + 3}" y1="{cy*37}" x2="{cx*37 + ($r * 37) -1}"
							y2="{cy*37}" stroke="blue" stroke-width="3" />

						<!-- le nom du centre de la cercle -->
						<text x="{cx*37 - 2}" y="{cy*37 - 7}"
							style="fill:black;font-size:25px;font-style:italic;">O</text>

						<!-- le nom du rayon -->
						<text x="{cx*37 + ($r * 37) div 2 }" y="{cy*37 -7}"
							style="fill:black;font-size:25px;font-style:italic;">
							r=
							<xsl:value-of select="$r"></xsl:value-of>
							cm
						</text>

						<!-- le nom de la cercle -->
						<text x="{cx*37 + ($r * 37)}" y="{cy*37 - ($r * 37) div 2}"
							style="fill:black;font-size:25px;font-style:italic;text-anchor:start;">
							<xsl:value-of select="$name"></xsl:value-of>
						</text>
					</xsl:if>

				</xsl:if>

				<xsl:if test="@type='triangle'">

					<xsl:variable name="name" select="name" />

					<polygon
						points="{37 * x1},{37 * y1} {37 * x2},{37 * y2} {37 * x3},{37 * y3}"
						stroke="{color}" stroke-width="4" fill="transparent" />

					<text x="{x2 *37 }" y="{y2 *37 -15}"
						style="fill:black;font-size:25px;font-style:italic;">
						<xsl:value-of select="$name"></xsl:value-of>
					</text>

				</xsl:if>

				<xsl:if test="@type='rectangle'">

					<!-- j'ai u tilisé les variables pour stocker le x et le x du rectangle 
						et pour differencier le x et le y du rectangle et du texte -->

					<xsl:variable name="name" select="name" />

					<xsl:variable name="x" select="x" />

					<xsl:variable name="y" select="y" />

					<rect width="{width * 37}" height="{height * 37}" x="{$x * 37}"
						y="{$y * 37}" stroke="{color}" stroke-width="4" fill="transparent" />

					<text x="{$x * 37 + (width * 37) div 2 }" y="{$y * 37 + (height * 37) div 2}"
						style="fill:black;font-size:25px;font-style:italic;">
						<xsl:value-of select="$name"></xsl:value-of>
					</text>

				</xsl:if>

				<xsl:if test="@type='line'">

					<xsl:variable name="name" select="name" />

					<xsl:variable name="x1" select="x1" />

					<xsl:variable name="x2" select="x2" />

					<xsl:variable name="y1" select="y1" />

					<xsl:variable name="y2" select="y2" />

					<line x1="{37 * $x1}" y1="{37 * $x2}" x2="{37 * $y1}" y2="{37 * $y2}"
						stroke="{color}" stroke-width="4" />

					<xsl:if test=" $y1 &lt; $y2  ">

						<text x="{$x1 * 37 + 5 }" y="{( $y1 * 37 ) + ($y1 + $y2)  div 2 }"
							style="fill:black;font-size:25px;font-style:italic;">
							<xsl:value-of select="$name"></xsl:value-of>
						</text>
					</xsl:if>

					<xsl:if test=" $y2 &lt; $y1  ">
						<text x="{$x1 * 37 + 5 }" y="{( $y2 * 37 ) + ($y1 + $y2 )  div 2 }"
							style="fill:black;font-size:25px;font-style:italic;">
							<xsl:value-of select="$name"></xsl:value-of>
						</text>
					</xsl:if>

				</xsl:if>

				<xsl:if test="@type='square'">

					<!-- j'ai u tilisé les variables pour stoquer le x et le x du carré 
						et pour differencier le x et le y du carré et du texte -->

					<xsl:variable name="name" select="name" />

					<xsl:variable name="x" select="x" />

					<xsl:variable name="y" select="y" />

					<rect width="{side * 37}" height="{side * 37}" x="{$x * 37}"
						y="{$y * 37}" stroke="{color}" stroke-width="4" fill="transparent" />

					<text x="{$x * 37 + (side * 37) div 2 }" y="{$y * 37 + (side * 37) div 2}"
						style="fill:black;font-size:25px;font-style:italic;">
						<xsl:value-of select="$name"></xsl:value-of>
					</text>

				</xsl:if>

			</xsl:for-each>
		</svg>
	</xsl:template>

</xsl:stylesheet>