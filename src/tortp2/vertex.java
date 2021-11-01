package tortp2;

public class vertex {

	int DistanceToS = 1000000;
	int IncominDistanceV1, IncominDistanceV2;
	int index;// the in dex of this class
	int parent;;
	int NV1, NV2, PV1, PV2;// NV next vertex and PV previous vertex

	public vertex(int index, int NV1, int NV2, int IncominDistanceV1, int IncominDistanceV2, int PV1, int PV2) {
		this.index = index;
		this.NV1 = NV1;
		this.IncominDistanceV1 = IncominDistanceV1;
		this.NV2 = NV2;
		this.IncominDistanceV2 = IncominDistanceV2;
		this.PV1 = PV1;
		this.PV2 = PV2;
	}

	public void getDistance(int Np, int distanceV) throws InterruptedException {

		if(Np == PV1 ) {
			if (distanceV + IncominDistanceV1 < DistanceToS) {
				DistanceToS = distanceV + IncominDistanceV1;
				parent = Np;
				System.out.println("I'm "+index+ " my distance with 0 is "+ DistanceToS +" ana my parent is "+Np);
			}
		}else if (Np == PV2 ) {
			if (distanceV + IncominDistanceV2 < DistanceToS) {
				DistanceToS = distanceV + IncominDistanceV2;
				parent = Np;
				System.out.println("I'm "+index+ " my distance with 0 is "+ DistanceToS +" ana my parent is "+Np);
				// System.out.println(distance);
			}
		}
		Thread.sleep(1000);
	}

	public void Display() {
		System.out.println("I'm " + index + " and my distance to is " + DistanceToS + " et mon pere est "+ parent);
	}

}
