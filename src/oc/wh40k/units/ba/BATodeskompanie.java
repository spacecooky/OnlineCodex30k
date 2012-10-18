package oc.wh40k.units.ba;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerStarter;

public class BATodeskompanie extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsEinzelUpgrade jet;
	OptionsEinzelUpgrade lemartes;
	RuestkammerStarter rkTransport;

	boolean added = false;

	public BATodeskompanie() {
		name = "Todeskompanie\n";
		grundkosten = 0;
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("BATodeskompanie", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Todgeweihte", 3, 30, 20);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BATodeskompanie.jpg"));

		seperator();

		add(lemartes = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ordenspriester Lemartes", 150));
		lemartes.setToolTipText("Deine Armee darf nur maximal einen Lemartes enthalten.");

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenpistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Infernus-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator();

		add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 0));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Transporter");
		rkTransport.initKammer(true, true, true, false);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl((squad.getModelle() * 2) - o2.getAnzahl());
		o2.setMaxAnzahl((squad.getModelle() + (lemartes.isSelected() ? 1 : 0)) / 5);

		jet.setPreis(squad.getModelle() * 15);
		rkTransport.setAktiv(!jet.isSelected());

		if (!added && lemartes.isSelected()) {
			BuildaHQ.addToInformationVector("BALemartes", 1);
			added = true;
			RefreshListener.fireRefresh();
		} else if (added && !lemartes.isSelected()) {
			BuildaHQ.addToInformationVector("BALemartes", -1);
			added = false;
			RefreshListener.fireRefresh();
		}

		lemartes.setLegal(BuildaHQ.getCountFromInformationVector("BALemartes") < 2);

		int astaroth = BuildaHQ.getCountFromInformationVector("BAAstorath");
		int todeskompanie = BuildaHQ.getCountFromInformationVector("BATodeskompanie");
		if(astaroth < 1 && todeskompanie > 1) {
			setFehlermeldung("0-1 Auswahl!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
        if(added) BuildaHQ.addToInformationVector("BALemartes",-1);
		BuildaHQ.addToInformationVector("BATodeskompanie", -1);
		super.deleteYourself();
	}

	public int getModelle() {
		return this.squad.getModelle();
	}

}
