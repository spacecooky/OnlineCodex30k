package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class NELeibgarde extends Eintrag {

	AnzahlPanel squad;
    OptionsUpgradeGruppe o1;
	RuestkammerStarter rkTransport;

	public NELeibgarde() {
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Leibgardisten", 5, 10, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/NELeibgarde.jpg"));

		seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Kriegssensen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwert & Schild", "Hyperphasenschwerter und Dispersionsschilde", 5));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();;

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NETransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        
        o1.setPreis(1, squad.getModelle() * 5);
	}

}
