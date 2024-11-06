export class Payload {
	private content: string;
	private statusCode: number;
	private fulfilled: boolean;

	constructor(content: any, statusCode: number) {
		this.content = content;
		this.statusCode = statusCode;

		if (String(statusCode).startsWith('2')) {
			this.fulfilled = true;
		} else {
			this.fulfilled = false;
		}
	}
}
