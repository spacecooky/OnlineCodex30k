package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class BATerminatorTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelZaehler o2;
	RuestkammerStarter rkTransport;

	public BATerminatorTrupp() {
		name = "Terminator-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminatoren", 5, 10, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BATerminatortrupp.jpg"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 30));
		ogE.addElement(new OptionsGruppeEintrag("Cyclone Raketenwerfer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator(8);

		add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kettenfaust", 0, 5));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Transporter");
		rkTransport.initKammer(false, false, true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle() / 5);
		o2.setMaxAnzahl(squad.getModelle() - 1); // Energieschwert des Sarges darf nicht getauscht werden
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
	}

}
