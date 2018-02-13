package com.decorators;

import org.displaytag.decorator.TableDecorator;

import com.bo.Destination;


public class DestinationActionsDecorator extends TableDecorator {

		public String getAddCommentLink() {

		Destination destination = (Destination) getCurrentRowObject();
		Long idDest = destination.getId();

		return "<a href=\"commenter?id=" + idDest + "\">ajouter un Commentaire</a>";
	}

} 